package net.minecraft.server;

public class to extends tq {

   private final alq a;


   public to(String var1, String var2, IChatBaseComponent var3, alq var4) {
      super(var1 + var2, var3);
      this.a = var4;
      int var5 = alq.b(var4);
      if(var5 != 0) {
         bsk.a.put(var1 + var5, this.k());
      }

   }
}
