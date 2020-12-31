package SQLHome;

class User 
{
    private int id;
    private String first_name, last_name, email, gender;
    
    public User(int id, String first_name, String last_name, String email, String gender)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }
    
    public int getid()
    {
        return id;
    }
    public String getfirst_name()
    {
        return first_name;
    }
    public String getlast_name()
    {
        return last_name;
    }
    public String getemail()
    {
        return email;
    }
    public String getgender()
    {
        return gender;
    }
}
