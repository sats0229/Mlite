/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HEROS
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByUserid", query = "SELECT o FROM Orders o WHERE o.userid = :userid")
    , @NamedQuery(name = "Orders.findByRecipientname", query = "SELECT o FROM Orders o WHERE o.recipientname = :recipientname")
    , @NamedQuery(name = "Orders.findByUseraddress", query = "SELECT o FROM Orders o WHERE o.useraddress = :useraddress")
    , @NamedQuery(name = "Orders.findByAddtype", query = "SELECT o FROM Orders o WHERE o.addtype = :addtype")
    , @NamedQuery(name = "Orders.findByPhonenumber", query = "SELECT o FROM Orders o WHERE o.phonenumber = :phonenumber")
    , @NamedQuery(name = "Orders.findByCity", query = "SELECT o FROM Orders o WHERE o.city = :city")
    , @NamedQuery(name = "Orders.findByState", query = "SELECT o FROM Orders o WHERE o.state = :state")
    , @NamedQuery(name = "Orders.findByPincode", query = "SELECT o FROM Orders o WHERE o.pincode = :pincode")
})
public class Orders implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private String userid;
    @Basic(optional = false)
    @Column(name = "RECIPIENTNAME")
    private String recipientname;
    @Basic(optional = false)
    @Column(name = "USERADDRESS")
    private String useraddress;
    @Basic(optional = false)
    @Column(name = "ADDTYPE")
    private String addtype;
    @Basic(optional = false)
    @Column(name = "PHONENUMBER")
    private long phonenumber;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @Column(name = "PINCODE")
    private int pincode;

    public Orders()
    {
    }

    public Orders(String userid)
    {
        this.userid = userid;
    }

    public Orders(String userid, String recipientname, String useraddress, String addtype, long phonenumber, String city, String state, int pincode)
    {
        this.userid = userid;
        this.recipientname = recipientname;
        this.useraddress = useraddress;
        this.addtype = addtype;
        this.phonenumber = phonenumber;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getRecipientname()
    {
        return recipientname;
    }

    public void setRecipientname(String recipientname)
    {
        this.recipientname = recipientname;
    }

    public String getUseraddress()
    {
        return useraddress;
    }

    public void setUseraddress(String useraddress)
    {
        this.useraddress = useraddress;
    }

    public String getAddtype()
    {
        return addtype;
    }

    public void setAddtype(String addtype)
    {
        this.addtype = addtype;
    }

    public long getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getPincode()
    {
        return pincode;
    }

    public void setPincode(int pincode)
    {
        this.pincode = pincode;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders))
        {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "DAo.Orders[ userid=" + userid + " ]";
    }
    
}
