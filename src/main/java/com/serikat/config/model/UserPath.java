package com.serikat.config.model;

public class UserPath {

	Long id;
	String originpath;
	String targetpath;
	String name;
	String activecheck;

	public String getActivecheck() {
		return activecheck;
	}

	public void setActivecheck(String activecheck) {
		this.activecheck = activecheck;
	}

	public String getOriginpath() {
		return originpath;
	}

	public void setOriginpath(String originpath) {
		this.originpath = originpath;
	}

	public String getTargetpath() {
		return targetpath;
	}

	public void setTargetpath(String targetpath) {
		this.targetpath = targetpath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserPath() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPath(Long id, String originpath, String targetpath, String name, String activecheck) {
		super();
		this.id = id;
		this.originpath = originpath;
		this.targetpath = targetpath;
		this.name = name;
		this.activecheck = activecheck;
	}

	// Hash & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activecheck == null) ? 0 : activecheck.hashCode());

		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((originpath == null) ? 0 : originpath.hashCode());
		result = prime * result + ((targetpath == null) ? 0 : targetpath.hashCode());
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
		UserPath other = (UserPath) obj;
		//*********** Active Check ***********************
		if (activecheck == null) {
			if (other.activecheck != null)
				return false;
		} else if (!activecheck.equals(other.activecheck))
			return false;
		//************************************************
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
		if (originpath == null) {
			if (other.originpath != null)
				return false;
		} else if (!originpath.equals(other.originpath))
			return false;
		if (targetpath == null) {
			if (other.targetpath != null)
				return false;
		} else if (!targetpath.equals(other.targetpath))
			return false;
		return true;
	}

}
