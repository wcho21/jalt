package jalt;

import java.util.Scanner;

public class QuickFind implements UnionFind {
  private int[] ids;
  private int numComponents;

  public QuickFind(int numComponents) {
    this.numComponents = numComponents;
    this.ids = new int[numComponents];
    for (int i = 0; i < numComponents; ++i) {
      this.ids[i] = i;
    }
  }

  public void union(int site1, int site2) {
    int id1 = this.find(site1);
    int id2 = this.find(site2);

    if (id1 == id2) {
      return;
    }

    for (int i = 0; i < this.ids.length; ++i) {
      if (this.ids[i] == id1) {
        this.ids[i] = id2;
      }
    }
    this.numComponents--;
  }

  public int find(int site) {
    return ids[site];
  }

  public boolean connected(int site1, int site2) {
    return find(site1) == find(site2);
  }

  public int count() {
    return this.numComponents;
  }

  // test
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numComponents = scanner.nextInt();

    UnionFind uf = new QuickFind(numComponents);
    while (scanner.hasNext()) {
      int site1 = scanner.nextInt();
      int site2 = scanner.nextInt();

      if (uf.connected(site1, site2)) {
        continue;
      }

      uf.union(site1, site2);
    }

    System.out.println(uf.count() + " components");
  }
}
