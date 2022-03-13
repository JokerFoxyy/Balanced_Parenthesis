import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		String fileName = args[0];

		try {

			// Pega o arquivo
			File filePath = new File("C:\\Users\\victo\\OneDrive\\Área de Trabalho\\Faculdade\\EC-6\\Compiladores\\Desafios\\" + fileName);

			// Pega o caminho do arquivo
			FileReader filePathRead = new FileReader(filePath);

			BufferedReader fileRead = new BufferedReader(filePathRead);

			boolean flag = true;
			
			OutputStream NovoArquivo = new FileOutputStream("NewFile.txt");
	        Writer wr = new OutputStreamWriter(NovoArquivo);
	        BufferedWriter Escritor = new BufferedWriter(wr);

			while (fileRead.ready()) {
				String text = fileRead.readLine();
								

				if (text.indexOf('(') > text.indexOf(')') || text.indexOf('{') > text.indexOf('}')
						|| text.indexOf('[') > text.indexOf(']')) {
					flag = false;
					text += "Inválido\n";
				} else if (text.indexOf('(') == -1 || text.indexOf(')') == -1 || text.indexOf('{') == -1
						|| text.indexOf('}') == -1 || text.indexOf('[') == -1 || text.indexOf(']') == -1) {
					flag = false;
					text += "Inválido\n";
				} else {
					text += "Válido\n";
				}	
								
								
		        Escritor.write(text);
			}
			
			
			fileRead.close();
			Escritor.close();

		} catch (Exception e) {
			System.out.println("File not found!\n A exceção é: "+e);
		}
		

	}

}
