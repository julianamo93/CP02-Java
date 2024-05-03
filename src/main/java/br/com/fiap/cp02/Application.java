package br.com.fiap.cp02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import br.com.fiap.cp02.Model.User;
import br.com.fiap.cp02.Service.GitHubService;
import br.com.fiap.cp02.Connection.ConexaoDB;

public class Application {

    public static void main(String[] args) {
        String filePath = "C://temp/login_git.txt";

        StringBuilder content = new StringBuilder();

        try {
            File file = new File(filePath);

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }

            bufferedReader.close();

            User obj = GitHubService.getUser(content.toString());

            if (obj != null) {
                System.out.println("Nome: " + obj.getName() + "\n");
                System.out.println("Qtd. Repositórios: " + obj.getPublic_repos() + "\n");
                System.out.println("Qtd. Seguidores: " + obj.getFollowers() + "\n");
                System.out.println("Qtd. Seguindo: " + obj.getFollowing() + "\n");

                ConexaoDB db = new ConexaoDB();
                db.InsertUser(obj);

            } else {
                System.out.println("Usuário não encontrado.");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }


        System.out.println("Conteúdo do arquivo:");
        System.out.println(content.toString());
    }
}



