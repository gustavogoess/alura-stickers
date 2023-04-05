import java.io.InputStream;
import java.net.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        //String url= "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudoNasa extrator = new ExtratorDeConteudoNasa();
        
        
        String url= "http://localhost:8080/linguagens";
        //String url= "https://alura-linguagens.fly.dev/linguagens";
        
        ExtratorDeConteudo extrator= new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp ();
        String json=http.buscaDados(url);

        // Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora= new GeradoraDeFigurinha();
        for (int i=0; i<4; i++) {

            Conteudo conteudo= conteudos.get(i);

            InputStream inputStream= new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo= "geradoradefigurinhas/saida/" + conteudo.getTitulo() + " .png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}