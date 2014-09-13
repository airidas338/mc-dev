package net.minecraft.server;

public class to extends tq {

   private final Item a;


   public to(String var1, String var2, IChatBaseComponent var3, Item var4) {
      super(var1 + var2, var3);
      this.a = var4;
      int var5 = Item.b(var4);
      if(var5 != 0) {
         IScoreboardCriteria.criteria.put(var1 + var5, this.k());
      }

   }
}
