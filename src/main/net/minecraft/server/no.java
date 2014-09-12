package net.minecraft.server;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class no implements id {

   private static final Gson a = (new GsonBuilder()).registerTypeAdapter(ServerPingServerData.class, new nu()).registerTypeAdapter(ServerPingPlayerSample.class, new nr()).registerTypeAdapter(ServerPing.class, new ns()).registerTypeHierarchyAdapter(IChatBaseComponent.class, new hp()).registerTypeHierarchyAdapter(ChatModifier.class, new hx()).registerTypeAdapterFactory(new ut()).create();
   private ServerPing b;


   public no() {}

   public no(ServerPing var1) {
      this.b = var1;
   }

   public void a(hd var1) {
      this.b = (ServerPing)a.fromJson(var1.c(32767), ServerPing.class);
   }

   public void b(hd var1) {
      var1.a(a.toJson(this.b));
   }

   public void a(PacketListener var1) {
      ((nm)var1).a(this);
   }

}
