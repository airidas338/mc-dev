package net.minecraft.server;

public class ata implements vv {

   private final World a;
   private final Location b;


   public ata(World var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public String getName() {
      return "anvil";
   }

   public boolean k_() {
      return false;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return new ChatMessage(Blocks.ANVIL.a() + ".name", new Object[0]);
   }

   public aib a(ahb var1, EntityHuman var2) {
      return new aid(var1, this.a, this.b, var2);
   }

   public String k() {
      return "minecraft:anvil";
   }
}
