package com.xh.util;

import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.xh.paras.DOMParas;
import com.xh.paras.NodeTree;
import com.xh.paras.Paras;

public class DbManage {
	List<NodeTree> provinces;// 省
	List<NodeTree> regions;// 地区
    private static WeakReference<DbManage> reference;
	private static DbManage init() {
		if (reference == null)
			synchronized (DbManage.class.getName()) {
				if (reference == null)
					reference=new WeakReference<DbManage>(new DbManage());
			}
		return reference.get();
	}

	public static DbManage getDbManage() {
		if (reference == null)
			init();
		return reference.get();
	}

	private DbManage() {
		Paras saxParas = DOMParas.init();
		URL path=DbManage.class.getResource("/db/province.xml");
		NodeTree province = saxParas.uri2nodeTree(DbManage.class.getResource("/db/province.xml").toString());
		if (province != null)
			provinces = province.getChildNodeTrees();
		NodeTree region = saxParas.uri2nodeTree(DbManage.class.getResource("/db/region.xml").toString());
		if (region != null)
			regions = region.getChildNodeTrees();
	}

	/**
	 * 查看所有的地区
	 * 
	 * @return
	 */
	public List<String> select_region() {
		List<String> region = new ArrayList<String>();
		if (is_traverse(regions)) {
			for (NodeTree nodeTree : regions) {
				region.add(nodeTree.getName());
			}
		}
		return region;
	}

	/**
	 * 查看是否为地区
	 * 
	 * @param region
	 * @return
	 */
	public boolean is_region(String region) {
		return region_indext(region) != -1;
	}

	/**
	 * 获取地区中的省级地区
	 * 
	 * @param region
	 * @return
	 */
	public List<String> region2provinces(String region) {
		List<String> list = new ArrayList<String>();
		List<NodeTree> nodeTrees = region2nodeTree(region);
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree : nodeTrees) {
				list.add(nodeTree.getName());
			}
		return list;
	}

	/**
	 * 获取地区中的省级地区简称
	 * 
	 * @param region
	 * @return
	 */
	public List<String> region2provinceshorts(String region) {
		List<String> list = new ArrayList<String>();
		List<NodeTree> nodeTrees = region2nodeTree(region);
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree : nodeTrees) {
				list.add(nodeTree.getAttributes().get("acronym"));
			}
		return list;
	}

	/**
	 * 获取地区中的省级地区编码
	 * 
	 * @param region
	 * @return
	 */
	public List<String> region2provincecode(String region) {
		if (!is_traverse(provinces))
			return null;
		List<String> list = new ArrayList<String>();
		List<NodeTree> nodeTrees = region2nodeTree(region);
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree : nodeTrees) {
				String acronym = nodeTree.getAttributes().get("acronym");
				for (NodeTree nodeTree2 : provinces) {
					if (nodeTree2.getName().equals(acronym)) {
						list.add(nodeTree2.getAttributes().get("code"));
						break;
					}
				}
			}
		return list;
	}

	/**
	 * 获取地区中的市级地区
	 * 
	 * @param region
	 * @return
	 */
	public List<String> region2citys(String region) {
		if (!is_traverse(provinces))
			return null;
		List<String> list = new ArrayList<String>();
		List<NodeTree> nodeTrees = region2nodeTree(region);
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree : nodeTrees) {
				String acronym = nodeTree.getAttributes().get("acronym");
				for (NodeTree nodeTree2 : provinces) {
					if (nodeTree2.getName().equals(acronym)) {
						list.addAll(node_provinces2citys(nodeTree2));
						break;
					}
				}
			}
		return list;
	}

	/**
	 * 获取地区中的市级地区
	 * 
	 * @param region
	 * @return
	 */
	public List<String> provinces2citys(String province) {
		if (!is_traverse(provinces))
			return null;
		List<String> list = new ArrayList<String>();
		int index = province_indext(province);
		if (index != -1) {
			list.addAll(node_provinces2citys(provinces.get(index)));
		}
		return list;
	}

	/**
	 * 获取省级城市中的市级城市
	 * 
	 * @param nodeTree
	 * @return
	 */
	private List<String> node_provinces2citys(NodeTree nodeTree) {
		if (nodeTree == null)
			return null;
		List<NodeTree> nodeTrees = nodeTree.getChildNodeTrees();
		List<String> list = new ArrayList<String>();
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree2 : nodeTrees) {
				list.add(nodeTree2.getName());
			}
		return list;
	}

	/**
	 * 获取地区中的县级地区
	 * 
	 * @param region
	 * @return
	 */
	public List<String> region2county(String region) {
		if (!is_traverse(provinces))
			return null;
		List<String> list = new ArrayList<String>();
		List<NodeTree> nodeTrees = region2nodeTree(region);
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree : nodeTrees) {
				String acronym = nodeTree.getAttributes().get("acronym");
				for (NodeTree nodeTree2 : provinces) {
					if (nodeTree2.getName().equals(acronym)) {
						List<NodeTree> nodeTrees2 = nodeTree2
								.getChildNodeTrees();
						if (is_traverse(nodeTrees2))
							for (NodeTree nodeTree3 : nodeTrees2) {
								list.add(nodeTree3.getName());
							}
						break;
					}
				}
			}
		return list;
	}

	/**
	 * 获取地区中的市级地区
	 * 
	 * @param region
	 * @return
	 */
	public List<String> region2cityscode(String region) {
		if (!is_traverse(provinces))
			return null;
		List<String> list = new ArrayList<String>();
		List<NodeTree> nodeTrees = region2nodeTree(region);
		if (is_traverse(nodeTrees))
			for (NodeTree nodeTree : nodeTrees) {
				String acronym = nodeTree.getAttributes().get("acronym");
				for (NodeTree nodeTree2 : provinces) {
					if (nodeTree2.getName().equals(acronym)) {
						List<NodeTree> nodeTrees2 = nodeTree2
								.getChildNodeTrees();
						if (is_traverse(nodeTrees2))
							for (NodeTree nodeTree3 : nodeTrees2) {
								list
										.add(nodeTree2.getAttributes().get(
												"code")
												+ nodeTree3.getAttributes()
														.get("code"));
							}
						break;
					}
				}
			}
		return list;
	}

	/**
	 * 将地区转化为省级节点
	 * 
	 * @param region
	 * @return
	 */
	private List<NodeTree> region2nodeTree(String region) {
		int indext = region_indext(region);
		if (indext == -1)
			return null;
		return regions.get(indext).getChildNodeTrees();
	}

	/**
	 * 查看这个地区的位置
	 * 
	 * @param region
	 * @return
	 */
	private int region_indext(String region) {
		if (region == null || region.isEmpty())
			return -1;
		if (is_traverse(regions))
			for (int i = 0; i < regions.size(); i++) {
				if (region.equals(regions.get(i).getName()))
					return i;
			}
		return -1;
	}

	/**
	 * 查看这个城市的位置
	 * 
	 * @param province
	 * @return
	 */
	private int province_indext(String province) {
		if (province == null || province.isEmpty())
			return -1;
		if (is_traverse(provinces))
			for (int i = 0; i < provinces.size(); i++) {
				if (province.equals(provinces.get(i).getName()))
					return i;
			}
		return -1;
	}

	/**
	 * 查看这个城市的位置
	 * 
	 * @param province
	 * @return
	 */
	private int province_short_indext(String province) {
		if (province == null || province.isEmpty())
			return -1;
		if (is_traverse(provinces))
			for (int i = 0; i < provinces.size(); i++) {
				if (province.equals(provinces.get(i).getAttributes().get(
						"benelux")))
					return i;
			}
		return -1;
	}

	/**
	 * 获取省会城市
	 * 
	 * @param province
	 * @return
	 */
	public String capital(String province) {
		int indext = province_short_indext(province);
		if (indext == -1)
			return "";
		return provinces.get(indext).getAttributes().get("capital");
	}

	/**
	 * 获取省会城市
	 * 
	 * @param province
	 * @return
	 */
	public String short_capital(String province) {
		int indext = province_indext(province);
		if (indext == -1)
			return "";
		return provinces.get(indext).getAttributes().get("capital");
	}

	/**
	 * 是否可以遍历
	 * 
	 * @param objects
	 * @return
	 */
	private boolean is_traverse(List<NodeTree> nodeTrees) {
		return nodeTrees != null && nodeTrees.size() > 0;
	}

	/**
	 * 获取省中的市级城市
	 * 
	 * @param province
	 * @return
	 */
	public List<String> province_citys(String province) {
		int indext = province_short_indext(province);
		if (indext == -1)
			return null;
		List<NodeTree> nodeTrees = provinces.get(indext).getChildNodeTrees();
		if (!is_traverse(nodeTrees))
			return null;
		List<String> list = new ArrayList<String>();
		for (NodeTree nodeTree : nodeTrees) {
			list.add(nodeTree.getName());
		}
		return list;
	}
	
	/**
	 * 获取省
	 * author:xh
	 * email:825378291@qq.com
	 * time:2017-1-22 下午05:08:43
	 * @return
	 */
	public List<NodeTree> getProvinces() {
		return provinces;
	}
/**
 * 获取地区
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-22 下午05:08:56
 * @return
 */
	public List<NodeTree> getRegions() {
		return regions;
	}

	public static void main(String[] args) {
		DbManage dbManage = DbManage.init();
		System.out.println(dbManage.getProvinces().size());
//		for (String string : dbManage.select_region()) {
//			System.out.println(string);
//		}
	}
}
