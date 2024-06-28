// Classe Software
public class Software {
    private String name;
    private String installCommand;

    public Software(String name,String installCommand) {
        this.name = name;
        this.installCommand = installCommand;
    }

    public String getName() {
        return name;
    }

    public String getInstallCommand() {
        return installCommand;
    }
}
