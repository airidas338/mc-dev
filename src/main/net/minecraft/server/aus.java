package net.minecraft.server;

public class aus extends Block {

   protected aus() {
      super(Material.d);
      this.a(akf.c);
   }

   public boolean a(World var1, Location var2, IBlock var3, EntityHuman var4, ej var5, float var6, float var7, float var8) {
      if(var1.D) {
         return true;
      } else {
         var4.a((vv)(new aut(var1, var2)));
         return true;
      }
   }
}