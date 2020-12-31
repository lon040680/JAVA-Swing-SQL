package SQLHome;

class VIP 
{
    private int vip_id;
    private String vip_first_name, vip_last_name, vip_email, vip_gender;
   
    public VIP(int vip_id, String vip_first_name, String vip_last_name, String vip_email, String vip_gender)
    {
        this.vip_id = vip_id;
        this.vip_first_name = vip_first_name;
        this.vip_last_name = vip_last_name;
        this.vip_email = vip_email;
        this.vip_gender = vip_gender;
    }
    public int getvip_id()
    {
        return vip_id;
    }
    public String getvip_first_name()
    {
        return vip_first_name;
    }
    public String getvip_last_name()
    {
        return vip_last_name;
    }
    public String getvip_email()
    {
        return vip_email;
    }
    public String getvip_gender()
    {
        return vip_gender;
    }
}
