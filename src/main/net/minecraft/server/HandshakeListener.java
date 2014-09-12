package net.minecraft.server;

public class HandshakeListener implements na {

	private final MinecraftServer a;
	private final NetworkManager b;

	public HandshakeListener(MinecraftServer var1, NetworkManager var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(mz var1) {
		System.out.println("Got packet!!!!!");
      switch(rp.a[var1.a().ordinal()]) {
      case 1:
         this.b.a(gy.d);
         ChatComponentText var2;
         if(var1.b() > 47) {
            var2 = new ChatComponentText("Outdated server! I\'m still on 1.8");
            this.b.a((id)(new ng(var2)));
            this.b.a((IChatBaseComponent)var2);
         } else if(var1.b() < 47) {
            var2 = new ChatComponentText("Outdated client! Please use 1.8");
            this.b.a((id)(new ng(var2)));
            this.b.a((IChatBaseComponent)var2);
         } else {
            this.b.a((PacketListener)(new rq(this.a, this.b)));
         }
         break;
      case 2:
         this.b.a(gy.c);
         this.b.a((PacketListener)(new ru(this.a, this.b)));
         break;
      default:
         throw new UnsupportedOperationException("Invalid intention " + var1.a());
      }

   }

	public void a(IChatBaseComponent var1) {
	}
}
