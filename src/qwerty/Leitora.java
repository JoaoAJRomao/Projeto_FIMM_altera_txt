/**
 * 
 */
package qwerty;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Artur Cavalcante
 * @since 19 de fev de 2019 09:26:23
 * 
 *        Classe responsável por receber os parâmetros para leitura do arquivo
 */
public class Leitora {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String arquivoOrigem = "DADOSFUNCIONARIOSSANASA_DESCARTE.txt";

		String arquivoDestino = "DADOSFUNCIONARIOSSANASA_DESCARTE_ALT.txt";
//		String endereco = "AV ALMIRANTE BARROSO 411                                     CENTRO                        58013120                                                   ";
//		String endereco2 = "RUA THOMAZ ALVES BROWN 192                                  VILA JOAO JORGE               13041316                                             ";
//		String endereco3 = "RUA BARÃO DE JUNDIAÍ 330                                    CENTRO                        13201010                                             ";
//		String endereco4 = "RUA PADRE JOAO 106                                          CENTRO                        08710180                                             ";
//		String endereco5 = "RUA BARÃO DE JUNDIAÍ 330                                    CENTRO                        13201010                                             ";
//		String endereco6 = "RUA BARÃO DE JUNDIAÍ 330                                    CENTRO                        13201010                                             ";
//		String endereco7 = "RUA BARÃO DE JUNDIAÍ 330                                    CENTRO                        13201010                                             ";
		String endereco8 = "RUA PADRE JOAO 106                                          CENTRO                        08710180                                             ";

		try {

			List linhas = FileUtil.obterRegistros(arquivoOrigem);
			List linhasNovoArquivo = new LinkedList<String>();

			Iterator linhasIterator = linhas.iterator();

			while (linhasIterator.hasNext()) {

				String linha = (String) linhasIterator.next();
				String campo0 = FileUtil.obterCampoPorPosicao(linha, 1, 7);
				String campo1 = FileUtil.obterCampoPorPosicao(linha, 7, 7);
				String campo2 = FileUtil.obterCampoPorPosicao(linha, 8, 90);
				String campo3 = FileUtil.obterCampoPorPosicao(linha, 93, 93);
				String campo4 = FileUtil.obterCampoPorPosicao(linha, 97, 150);
				if (campo1.endsWith("6")) {
					linhasNovoArquivo.add(campo0 + endereco8);
				} else if (campo1.endsWith("2")) {
					campo0 = FileUtil.obterCampoPorPosicao(linha, 1, 6);
					linhasNovoArquivo.add(campo0 + campo1 + campo2 + "00" + campo3 + "293" + campo4);
				} else {
					linhasNovoArquivo.add(linha);
				}
			}
			FileUtil.escreverArquivo(arquivoDestino, linhasNovoArquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
