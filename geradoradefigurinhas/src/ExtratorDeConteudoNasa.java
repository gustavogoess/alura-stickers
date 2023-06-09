import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos (String json) {
        
        // Extrair só os dados que interessam (Título, posster, rank)
        var parser = new jsonParser();
        List<Map<String, String>> listaDeAtributo = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributo) {
            String titulo= atributos.get("title");
            String urlImagem= atributos.get("url");
            
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }

}