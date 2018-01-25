package com.xh.reference;

public class Test {
	public static void main(String[] args) {
		XHMapRefrence<Txt> xhMapRefrence = ReferenceManage
				.gXhMapWeakReference();
		while (true) {
			try {
				Txt txt = xhMapRefrence.get("xiaoming");
				if (txt == null) {
					txt = new Txt();
					txt.setName("xiaoming");
					txt.setId("Éµ±Æ");
					xhMapRefrence.add(txt.getName(), txt);
					txt = null;
				} else {
					System.out.println(txt);
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	static class Txt {
		String name;
		String id;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{\"name\":" + name + ",\"id\":" + id + "}";
		}
	}
}
