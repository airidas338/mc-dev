package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bnk extends bnp {

   public WorldChunkManager a;
   public boolean b;
   public int c;
   public bne d;
   public List e;
   public List f = Lists.newArrayList();
   public List g = Lists.newArrayList();


   public bnk() {}

   public bnk(WorldChunkManager var1, int var2, Random var3, int var4, int var5, List var6, int var7) {
      super((bnk)null, 0, var3, var4, var5);
      this.a = var1;
      this.e = var6;
      this.c = var7;
      BiomeBase var8 = var1.a(new Location(var4, 0, var5), BiomeBase.ad);
      this.b = var8 == BiomeBase.r || var8 == BiomeBase.G;
      this.a(this.b);
   }

   public WorldChunkManager e() {
      return this.a;
   }
}
