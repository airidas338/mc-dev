package net.minecraft.server;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class no implements id {

   private static final Gson a = (new GsonBuilder()).registerTypeAdapter(nt.class, new nu()).registerTypeAdapter(nq.class, new nr()).registerTypeAdapter(np.class, new ns()).registerTypeHierarchyAdapter(ho.class, new hp()).registerTypeHierarchyAdapter(hv.class, new hx()).registerTypeAdapterFactory(new ut()).create();
   private np b;


   public no() {}

   public no(np var1) {
      this.b = var1;
   }

   public void a(hd var1) {
      this.b = (np)a.fromJson(var1.c(32767), np.class);
   }

   public void b(hd var1) {
      var1.a(a.toJson(this.b));
   }

   public void a(nm var1) { // nm
      var1.a(this);
   }

}
