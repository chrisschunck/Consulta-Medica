package br.com.agendamento.adapters.in.web;

import br.com.agendamento.adapters.out.persistence.UsuarioJpaRepository;
import br.com.agendamento.domain.model.UsuarioJava;
import br.com.agendamento.security.TokenService;
import br.com.agendamento.security.UserDetailsServiceImpl;
import br.com.agendamento.security.dto.AuthDTO.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioJpaRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthController(AuthenticationManager authenticationManager,
                          UsuarioJpaRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          TokenService tokenService,
                          UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    // -----------------------------------------------
    // API REST — para uso com Postman / mobile / etc.
    // -----------------------------------------------

    @PostMapping(value = "/login", consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<TokenResponse> loginApi(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = tokenService.gerarToken(userDetails);
        UsuarioJava usuario = usuarioRepository.findByEmail(request.email()).orElseThrow();
        return ResponseEntity.ok(new TokenResponse(token, "Bearer",
                usuario.getEmail(), usuario.getRole().name()));
    }

    @PostMapping(value = "/registro", consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> registroApi(@Valid @RequestBody RegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.email()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ja cadastrado.");
        salvarUsuario(request.nome(), request.email(), request.senha(), request.role());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario cadastrado: " + request.email());
    }

    // -----------------------------------------------
    // WEB — formulários Thymeleaf
    // -----------------------------------------------

    @PostMapping("/login-web")
    public String loginWeb(@RequestParam String email,
                           @RequestParam String senha,
                           HttpSession session) {
        try {
            // Autentica o usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, senha));

            // Coloca no contexto do Spring Security (cria sessao)
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute("SPRING_SECURITY_CONTEXT",
                    SecurityContextHolder.getContext());

            // Gera o token JWT e guarda na sessao tambem
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = tokenService.gerarToken(userDetails);
            session.setAttribute("JWT_TOKEN", token);
            session.setAttribute("USUARIO_EMAIL", email);

            UsuarioJava usuario = usuarioRepository.findByEmail(email).orElseThrow();
            session.setAttribute("USUARIO_ROLE", usuario.getRole().name());
            session.setAttribute("USUARIO_NOME", usuario.getNome());

            return "redirect:/";

        } catch (BadCredentialsException e) {
            return "redirect:/login?erro=true";
        } catch (Exception e) {
            return "redirect:/login?erro=true";
        }
    }

    @PostMapping("/registro-web")
    public String registroWeb(@RequestParam String nome,
                              @RequestParam String email,
                              @RequestParam String senha,
                              @RequestParam String role) {
        try {
            if (usuarioRepository.existsByEmail(email))
                return "redirect:/registro?erro=Email+ja+cadastrado";

            salvarUsuario(nome, email, senha, role);
            return "redirect:/login?sucesso=true";

        } catch (Exception e) {
            return "redirect:/registro?erro=Erro+ao+cadastrar+usuario";
        }
    }

    @GetMapping("/logout-web")
    public String logoutWeb(HttpSession session) {
        session.invalidate();
        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }

    // -----------------------------------------------
    // Metodo auxiliar
    // -----------------------------------------------

    private void salvarUsuario(String nome, String email, String senha, String role) {
        UsuarioJava usuario = new UsuarioJava();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setRole(UsuarioJava.Role.valueOf(role.toUpperCase()));
        usuarioRepository.save(usuario);
    }
}