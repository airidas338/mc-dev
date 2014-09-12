package net.minecraft.server;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class nu implements JsonDeserializer, JsonSerializer {

   public ServerPingServerData a(JsonElement var1, Type var2, JsonDeserializationContext var3) {
      JsonObject var4 = uh.l(var1, "version");
      return new ServerPingServerData(uh.h(var4, "name"), uh.m(var4, "protocol"));
   }

   public JsonElement a(ServerPingServerData var1, Type var2, JsonSerializationContext var3) {
      JsonObject var4 = new JsonObject();
      var4.addProperty("name", var1.a());
      var4.addProperty("protocol", Integer.valueOf(var1.b()));
      return var4;
   }

   // $FF: synthetic method
   public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
      return this.a((ServerPingServerData)var1, var2, var3);
   }

   // $FF: synthetic method
   public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) {
      return this.a(var1, var2, var3);
   }
}
