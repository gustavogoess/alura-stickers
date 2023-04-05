import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
/*import java.net.URL;
import java.io.FileInputStream;
*/

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {

    /**
     * @throws Exception
     */
    public void cria(InputStream inputStream, String nomeArquivo ) throws Exception{

        //leitura da imagem

        //InputStream inputStream= 
        //new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        
        BufferedImage imagemOriginal=ImageIO.read(inputStream);
        

		//cria nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura= (int) (altura * 1.1 );
        //int novaAltura= altura +200 ;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		//copiar a imagem original pra novo imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0 , 0 , null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, (int)(altura*0.05));
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);

		// escrever uma frase na nova imagem
        String frase="TOPZERA";
        FontMetrics metrica= graphics.getFontMetrics();
        int meio = (largura-metrica.stringWidth(frase))/2;
        graphics.drawString(frase, meio,  novaAltura-10);

		//escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}