package br.com.inthurn.VilaDevInHouse.model.view.villager;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
public class ExternalIdAndFullNameView {

    @Id
    private Long id;

    private String ExternalId;
    private String name;
    private String surname;

    public ExternalIdAndFullNameView() {
    }

    public ExternalIdAndFullNameView(Long id, String externalId, String name, String surname) {
        this.id = id;
        ExternalId = externalId;
        this.name = name;
        this.surname = surname;
    }

    public ExternalIdAndFullNameView(String externalId, String name, String surname) {
        ExternalId = externalId;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getExternalId() {
        return ExternalId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
