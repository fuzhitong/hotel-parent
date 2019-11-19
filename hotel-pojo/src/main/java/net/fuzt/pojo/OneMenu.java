package net.fuzt.pojo;

import java.io.Serializable;
import java.util.List;

public class OneMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5800046179639172357L;
	private Long oneId;
	private String oneName;
	private List<TwoMenu> twoMenuList;
	public Long getOneId() {
		return oneId;
	}
	public void setOneId(Long oneId) {
		this.oneId = oneId;
	}
	public String getOneName() {
		return oneName;
	}
	public void setOneName(String oneName) {
		this.oneName = oneName;
	}
	/**
	 * @return the twoMenuList
	 */
	public List<TwoMenu> getTwoMenuList() {
		return twoMenuList;
	}
	/**
	 * @param twoMenuList the twoMenuList to set
	 */
	public void setTwoMenuList(List<TwoMenu> twoMenuList) {
		this.twoMenuList = twoMenuList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OneMenu [oneId=" + oneId + ", oneName=" + oneName + ", twoMenuList=" + twoMenuList + "]";
	}

}
