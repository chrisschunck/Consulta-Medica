package br.com.agendamento.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RecaptchaService {

    // É recomendado carregar a chave do application.properties
    @Value("${recaptcha.secret.key:6Ldxs4UtAAAAAIWoxylMwpjwI2u6bw44nCbHV0RJ}")
    private String recaptchaSecret;

    private static final String RECAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify";

    public boolean validarRecaptcha(String recaptchaResponseToken) {
        if (recaptchaResponseToken == null || recaptchaResponseToken.isEmpty()) {
            return false;
        }

        RestTemplate restTemplate = new RestTemplate();

        // Parâmetros do corpo da requisição (x-www-form-urlencoded)
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("secret", recaptchaSecret);
        params.add("response", recaptchaResponseToken);

        try {
            // Executa a requisição para a API do Google
            Map<String, Object> response = restTemplate.postForObject(RECAPTCHA_URL, params, Map.class);

            if (response != null && response.containsKey("success")) {
                return (Boolean) response.get("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
