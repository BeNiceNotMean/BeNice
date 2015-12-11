package ec327.benice;

/**
 * Created by ericmooney on 12/1/15.
 */
public class Contact
{
    private String _id, _name, _phone;

    public Contact(String id, String name, String phone)
    {
        _id = id;
        _name = name;
        _phone = phone;
    }

    public String get_id()
    {
        return _id;
    }

    public String get_name()
    {
        return _name;
    }

    public String get_phone()
    {
        return _phone;
    }

}
