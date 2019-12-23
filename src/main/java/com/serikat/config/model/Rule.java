package com.serikat.config.model;



public class Rule  {
	Long id;
String  word_to_rename;
String  renowned_word;
String name;
String activecheck;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getWord_to_rename() {
	return word_to_rename;
}
public void setWord_to_rename(String word_to_rename) {
	this.word_to_rename = word_to_rename;
}
public String getRenowned_word() {
	return renowned_word;
}
public void setRenowned_word(String renowned_word) {
	this.renowned_word = renowned_word;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getActivecheck() {
	return activecheck;
}
public void setActivecheck(String activecheck) {
	this.activecheck = activecheck;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((activecheck == null) ? 0 : activecheck.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((renowned_word == null) ? 0 : renowned_word.hashCode());
	result = prime * result + ((word_to_rename == null) ? 0 : word_to_rename.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Rule other = (Rule) obj;
	if (activecheck == null) {
		if (other.activecheck != null)
			return false;
	} else if (!activecheck.equals(other.activecheck))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (renowned_word == null) {
		if (other.renowned_word != null)
			return false;
	} else if (!renowned_word.equals(other.renowned_word))
		return false;
	if (word_to_rename == null) {
		if (other.word_to_rename != null)
			return false;
	} else if (!word_to_rename.equals(other.word_to_rename))
		return false;
	return true;
}
public Rule(Long id, String word_to_rename, String renowned_word, String name, String activecheck) {
	super();
	this.id = id;
	this.word_to_rename = word_to_rename;
	this.renowned_word = renowned_word;
	this.name = name;
	this.activecheck = activecheck;
}
public Rule() {
	super();
	// TODO Auto-generated constructor stub
}


}
