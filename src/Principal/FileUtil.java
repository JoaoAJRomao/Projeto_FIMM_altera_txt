/**
 * 
 */
package Principal;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Artur Cavalcante
 * @since 19 de fev de 2019 09:05:20
 * 
 *
 */
public class FileUtil {
	
	public static List obterRegistros(String arquivo) throws IOException  {

		File file = new File( arquivo);
		List linhas = FileUtils.readLines(file, Charset.defaultCharset());
		
		return linhas;
	}
	
	public static void escreverArquivo(String nome, List linhas) throws IOException {

		File file = new File( nome);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileUtils.writeLines(file, linhas, null);

	}
	
	public static String obterCampoPorPosicao(String linha, int posInicio, int posFim) {

		String campo;

		try {

			campo = linha.substring(posInicio - 1, posFim);

		} catch (IndexOutOfBoundsException e) {
			campo = "";
		}

		return campo;
	}
}
