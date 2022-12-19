package Assignment5;

//import com.fasterxml.jackson.annotation.*;
//
//import javax.annotation.Generated;
//import java.util.HashMap;
//import java.util.Map;


//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "_id",
//        "firstName",
//        "lastName",
//        "email",
//        "__v"
//})
//@Generated("jsonschema2pojo")
//public class userList {
//
//    @JsonProperty("_id")
//    private String id;
//    @JsonProperty("firstName")
//    private String firstName;
//    @JsonProperty("lastName")
//    private String lastName;
//    @JsonProperty("email")
//    private String email;
//    @JsonProperty("__v")
//    private Integer v;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @JsonProperty("_id")
//    public String getId() {
//        return id;
//    }
//
//    @JsonProperty("_id")
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @JsonProperty("firstName")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    @JsonProperty("firstName")
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @JsonProperty("lastName")
//    public String getLastName() {
//        return lastName;
//    }
//
//    @JsonProperty("lastName")
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @JsonProperty("email")
//    public String getEmail() {
//        return email;
//    }
//
//    @JsonProperty("email")
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @JsonProperty("__v")
//    public Integer getV() {
//        return v;
//    }
//
//    @JsonProperty("__v")
//    public void setV(Integer v) {
//        this.v = v;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//}


//-----------------------------------assigment5.Data.java-----------------------------------


import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})
@Generated("jsonschema2pojo")
public class userList {

    @JsonProperty("data")
    private Data data;
    @JsonProperty("support")
    private Support support;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("support")
    public Support getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Support support) {
        this.support = support;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


