package br.com.ecommerce.Domain.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

import br.com.ecommerce.Application.Service.IEnderecoService;
import br.com.ecommerce.Domain.Entities.EnderecoEntity;

public class EnderecoService implements IEnderecoService {

  @Override
  public EnderecoEntity pesquisaCep(String cep) {
    try {
      URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
      URLConnection connection = url.openConnection();
      InputStream is = connection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

      String aux_cep = "";
      StringBuilder jsonCep = new StringBuilder();

      while ((aux_cep = br.readLine()) != null) {
        jsonCep.append(aux_cep);
      }

      return new Gson().fromJson(jsonCep.toString(), EnderecoEntity.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
