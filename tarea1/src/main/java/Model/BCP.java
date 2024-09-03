package Model;

import java.util.HashMap;
import java.util.Map;

public class BCP {
    private int instructionNumber;
    private String instructionName;
    private String register;
    private int registerValue;
    private Map<String, Integer> registers;
    private int AC; // Acumulador

    public BCP() {
        this.instructionNumber = 0;
        this.instructionName = "";
        this.register = "";
        this.registerValue = 0;
        this.registers = new HashMap<>();
        this.AC = 0;
        // Inicializar los registros AX, BX, CX, DX en 0
        this.registers.put("AX", 0);
        this.registers.put("BX", 0);
        this.registers.put("CX", 0);
        this.registers.put("DX", 0);
    }

    public void updateBCP(int instructionNumber, String instructionName, String register, int registerValue) {
        this.instructionNumber = instructionNumber;
        this.instructionName = instructionName;
        this.register = register;
        this.registerValue = registerValue;

        // Actualizar el registro especificado
        if (this.registers.containsKey(register)) {
            this.registers.put(register, registerValue);
        }
    }

    public void executeInstruction(String instruction, int instructionNumber) {
        String[] parts = instruction.split(" ");
        String instructionName = parts[0];
        String register = parts[1].replace(",", "");
        int value = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;

        switch (instructionName) {
            case "MOV":
                updateBCP(instructionNumber, instructionName, register, value);
                break;
            case "ADD":
                this.AC += registers.getOrDefault(register, 0);
                updateBCP(instructionNumber, instructionName, register, registers.get(register));
                break;
            case "SUB":
                this.AC -= registers.getOrDefault(register, 0);
                updateBCP(instructionNumber, instructionName, register, registers.get(register));
                break;
            case "LOAD":
                this.AC = registers.getOrDefault(register, 0);
                updateBCP(instructionNumber, instructionName, register, registers.get(register));
                break;
            case "STORE":
                registers.put(register, this.AC);
                updateBCP(instructionNumber, instructionName, register, this.AC);
                break;
            // Agregar otros casos según sea necesario
        }
    }

    @Override
    public String toString() {
        return "BCP: \n" +
                "Instruction Number: " + instructionNumber + "\n" +
                "Instruction Name: " + instructionName + "\n" +
                "Register: " + register + "\n" +
                "Register Value: " + registerValue + "\n" +
                "Registers: " + registers + "\n" +
                "AC: " + AC + "\n";
    }
}
