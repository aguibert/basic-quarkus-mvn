package org.aguibert.quarkus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@RegisterForReflection
public class Example extends PanacheEntityBase {

   @Id
   @SequenceGenerator(
      name = "cellSequence",
      sequenceName = "cell_id_seq",
      allocationSize = 1,
      initialValue = 10)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cellSequence")
   public Integer id;

   @NotNull
   public String type;

   @NotNull
   public String content;

}