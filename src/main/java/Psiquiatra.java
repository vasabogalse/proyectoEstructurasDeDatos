public class Psiquiatra implements handleJSON {
    public int idPsiquiatra;
    public String emailPsiquiatra;
    public String clavePsiquiatra;

    public Psiquiatra(){ }

    public Psiquiatra(int idPsiquiatra, String emailPsiquiatra, String clavePsiquiatra) {
        this.idPsiquiatra = idPsiquiatra;
        this.emailPsiquiatra = emailPsiquiatra;
        this.clavePsiquiatra = clavePsiquiatra;
    }

    public int getIdPsiquiatra() { return idPsiquiatra; }
    public void setIdPsiquiatra(int idPsiquiatra) { this.idPsiquiatra = idPsiquiatra; }
    public String getEmailPsiquiatra() { return emailPsiquiatra; }
    public void setEmailPsiquiatra(String emailPsiquiatra) { this.emailPsiquiatra = emailPsiquiatra; }
    public String getClavePsiquiatra() { return clavePsiquiatra; }
    public void setClavePsiquiatra(String clavePsiquiatra) { this.clavePsiquiatra = clavePsiquiatra; }

    @Override
    public String toString() {
        return "{"  + "\n" +
                "idPsiquiatra : " + idPsiquiatra + "," + "\n" +
                "emailPsiquiatra : " + emailPsiquiatra + "," + "\n" +
                "clavePsiquiatra : " + clavePsiquiatra + "," + "\n" +
                '}';
    }
}
