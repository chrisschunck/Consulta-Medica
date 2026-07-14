package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.*;
import br.com.agendamento.domain.ports.in.*;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final PacienteUseCase pacienteUseCase;
    private final MedicoUseCase medicoUseCase;
    private final AgendamentoUseCase agendamentoUseCase;
    private final ConsultorioUseCase consultorioUseCase;
    private final ConvenioMedicoUseCase convenioMedicoUseCase;

    public HomeController(PacienteUseCase pacienteUseCase,
                          MedicoUseCase medicoUseCase,
                          AgendamentoUseCase agendamentoUseCase,
                          ConsultorioUseCase consultorioUseCase,
                          ConvenioMedicoUseCase convenioMedicoUseCase) {
        this.pacienteUseCase = pacienteUseCase;
        this.medicoUseCase = medicoUseCase;
        this.agendamentoUseCase = agendamentoUseCase;
        this.consultorioUseCase = consultorioUseCase;
        this.convenioMedicoUseCase = convenioMedicoUseCase;
    }

    // ---------- LOGIN / REGISTRO ----------

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String erro,
                        @RequestParam(required = false) String sucesso,
                        Model model) {
        if (erro != null) model.addAttribute("erro", "Email ou senha inválidos.");
        if (sucesso != null) model.addAttribute("sucesso", "Conta criada com sucesso! Faça login.");
        return "login";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    // ---------- INICIO ----------

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalPacientes", pacienteUseCase.listarTodos().size());
        model.addAttribute("totalMedicos", medicoUseCase.listarTodos().size());
        model.addAttribute("totalAgendamentos", agendamentoUseCase.listarTodos().size());
        return "index";
    }

    // ---------- PACIENTES ----------

    @GetMapping("/pacientes")
    public String pacientes(Model model) {
        model.addAttribute("pacientes", pacienteUseCase.listarTodos());
        if (!model.containsAttribute("paciente"))
            model.addAttribute("paciente", new PacienteJava());
        return "pacientes";
    }

    @PostMapping("/pacientes")
    public String salvarPaciente(@Valid @ModelAttribute("paciente") PacienteJava paciente,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pacientes", pacienteUseCase.listarTodos());
            return "pacientes";
        }
        pacienteUseCase.salvar(paciente);
        return "redirect:/pacientes";
    }

    // ---------- MEDICOS ----------

    @GetMapping("/medicos")
    public String medicos(Model model) {
        model.addAttribute("medicos", medicoUseCase.listarTodos());
        model.addAttribute("senioridades", Senioridade.values());
        if (!model.containsAttribute("medico"))
            model.addAttribute("medico", new MedicoJava());
        return "medicos";
    }

    @PostMapping("/medicos")
    public String salvarMedico(@Valid @ModelAttribute("medico") MedicoJava medico,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("medicos", medicoUseCase.listarTodos());
            model.addAttribute("senioridades", Senioridade.values());
            return "medicos";
        }
        medicoUseCase.salvar(medico);
        return "redirect:/medicos";
    }

    // ---------- CONSULTORIOS ----------

    @GetMapping("/consultorios")
    public String consultorios(Model model) {
        model.addAttribute("consultorios", consultorioUseCase.listarTodos());
        if (!model.containsAttribute("consultorio"))
            model.addAttribute("consultorio", new ConsultorioJava());
        return "consultorios";
    }

    @PostMapping("/consultorios")
    public String salvarConsultorio(@Valid @ModelAttribute("consultorio") ConsultorioJava consultorio,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("consultorios", consultorioUseCase.listarTodos());
            return "consultorios";
        }
        consultorioUseCase.salvar(consultorio);
        return "redirect:/consultorios";
    }

    // ---------- CONVENIOS ----------

    @GetMapping("/convenios")
    public String convenios(Model model) {
        model.addAttribute("convenios", convenioMedicoUseCase.listarTodos());
        if (!model.containsAttribute("convenio"))
            model.addAttribute("convenio", new ConvenioMedicoJava());
        return "convenios";
    }

    @PostMapping("/convenios")
    public String salvarConvenio(@Valid @ModelAttribute("convenio") ConvenioMedicoJava convenio,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("convenios", convenioMedicoUseCase.listarTodos());
            return "convenios";
        }
        convenioMedicoUseCase.salvar(convenio);
        return "redirect:/convenios";
    }

    // ---------- AGENDAMENTOS ----------

    @GetMapping("/agendamentos")
    public String agendamentos(Model model) {
        model.addAttribute("agendamentos", agendamentoUseCase.listarTodos());
        model.addAttribute("medicos", medicoUseCase.listarTodos());
        model.addAttribute("pacientes", pacienteUseCase.listarTodos());
        model.addAttribute("consultorios", consultorioUseCase.listarTodos());
        model.addAttribute("convenios", convenioMedicoUseCase.listarTodos());
        return "agendamentos";
    }

    @PostMapping("/agendamentos")
    public String salvarAgendamento(@RequestParam Long medicoId,
                                    @RequestParam Long pacienteId,
                                    @RequestParam Long consultorioId,
                                    @RequestParam(required = false) Long convenioId,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                    LocalDateTime horarioAgendado,
                                    @RequestParam String descricao) {
        AgendamentoJava agendamento = new AgendamentoJava();
        agendamento.setMedico(medicoUseCase.buscarPorId(medicoId));
        agendamento.setPaciente(pacienteUseCase.buscarPorId(pacienteId));
        agendamento.setConsultorio(consultorioUseCase.buscarPorId(consultorioId));
        if (convenioId != null)
            agendamento.setConvenioMedico(convenioMedicoUseCase.buscarPorId(convenioId));
        agendamento.setHorarioAgendado(horarioAgendado);
        agendamento.setDescricao(descricao);
        agendamentoUseCase.salvar(agendamento);
        return "redirect:/agendamentos";
    }
}