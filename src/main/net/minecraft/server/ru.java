package net.minecraft.server;

public class ru implements nv {

   private final MinecraftServer a;
   private final NetworkManager b;


   public ru(MinecraftServer var1, NetworkManager var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(IChatBaseComponent var1) {}

   public void a(nx var1) {
      this.b.a((Packet)(new no(this.a.aE())));
   }

   public void a(nw var1) {
      this.b.a((Packet)(new nn(var1.a())));
   }
}
