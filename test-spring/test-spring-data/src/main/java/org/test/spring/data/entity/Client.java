package org.test.spring.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Client")
@Table(name="Client")
@NamedQueries({
        @NamedQuery(
                name = "Client.findByName",
                query = "SELECT c FROM Client c where c.prenom=:name")
})
@TableGenerator(
        name="ClientSequence",
        table="Sequence",
        pkColumnName="SE_Id",
        valueColumnName="SE_Value",
        allocationSize=1
)
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="ClientSequence")
    @Column(name = "id")
    private Long id;
    @Column(name = "nom", nullable=false)
    private String nom;
    @Column(name = "prenom", nullable=false)
    private String prenom;

    @Column(name = "typeClient", nullable=false)
    @Enumerated
    private TypeClient typeClient;

    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "dateModification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @Version
    @Column(name = "version")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeClient getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!dateCreation.equals(client.dateCreation)) return false;
        if (!dateModification.equals(client.dateModification)) return false;
        if (!id.equals(client.id)) return false;
        if (!nom.equals(client.nom)) return false;
        if (!prenom.equals(client.prenom)) return false;
        if (typeClient != client.typeClient) return false;
        if (!version.equals(client.version)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + typeClient.hashCode();
        result = 31 * result + dateCreation.hashCode();
        result = 31 * result + dateModification.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", typeClient=" + typeClient +
                ", dateCreation=" + dateCreation +
                ", dateModification=" + dateModification +
                ", version=" + version +
                '}';
    }

    @PrePersist
    public void Prepersist ()
    {
        Date now = new Date();
        this.dateCreation = now;
        this.dateModification = now;
    }

    @PreUpdate
    public void preUpdate ()
    {
        this.dateModification = new Date();
    }
}
