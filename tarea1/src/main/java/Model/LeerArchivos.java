package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 * @author johan
 */
public class LeerArchivos {
    private String filePath;
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public String leerArchivo() throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
                validarLinea(linea);
            }
        }
        return contenido.toString();
    }
    
    private void validarLinea(String line) throws IOException {
        Pattern movPattern = Pattern.compile("^MOV\\s+(AX|BX|CX|DX),\\s*(-?\\d+|AX|BX|CX|DX)$");
        Pattern addSubPattern = Pattern.compile("^(ADD|SUB)\\s+(AX|BX|CX|DX)$");
        Pattern loadStorePattern = Pattern.compile("^(LOAD|STORE)\\s+(AX|BX|CX|DX)$");

        if (!movPattern.matcher(line).matches() && 
            !addSubPattern.matcher(line).matches() && 
            !loadStorePattern.matcher(line).matches()) {
            throw new IOException("Error en la sintaxis de la línea: " + line);
        }
    }
}
