package com.xh.paras;

import java.util.List;

public class TestParas {
	public static void main(String[] args) {
		String uri = "src/db/phone.txt";
		Paras saxParas = DOMParas.init();
		NodeTree province = saxParas.uri2nodeTree(uri);
	}
}
