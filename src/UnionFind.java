package jalt;

public interface UnionFind {
  public void union(int site1, int site2);
  public int find(int site);
  public boolean connected(int site1, int site2);
  public int count();
}
