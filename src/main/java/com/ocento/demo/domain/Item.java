package com.ocento.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @ManyToOne
    private Type type;

    @ManyToOne
    private MediaFranchise mediaFranchise;

    @NonNull
    private LocalDate publishDate;

}
