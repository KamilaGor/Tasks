package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor//(Lombok) - generowanie pustego konstuktora
@AllArgsConstructor // z biblio Lombok - generowanie konstruktora na bazie wszystki pól klasy
@Entity(name = "tasks")// (hibernate) - info, że klasa jest reprezentacją tabeli w bazie danych
public class Task { //klasa Domenowa
	@Id//info dla hibernate, że to pole jest kluczem głównym tabeli w b.d.
	@GeneratedValue(strategy = GenerationType.AUTO)//info, że klucz główny generowany jest automatycznie
	private Long id;

	@Column(name = "name")//info, że to pole w klasie jest kolumną w b.d. (o podanej nazwie w argumencie)
	private String title;

	@Column(name = "description")
	private String content;
}
