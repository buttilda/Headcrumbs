package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.libs.Reference;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerProfileCache;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;

public class UsercacheChecker {

	private final static Logger logger = LogManager.getLogger(Reference.MOD_ID.toUpperCase());

	public static void check() {
		File file = MinecraftServer.field_152367_a;

		if (file.exists())
			try {
				GsonBuilder gsonbuilder = new GsonBuilder();
				gsonbuilder.registerTypeHierarchyAdapter(ProfileEntry.class, new Serializer(null));
				Gson gson = gsonbuilder.create();

				gson.fromJson(Files.newReader(file, Charsets.UTF_8), type);
			} catch (Exception e) {
				file.delete();
				logger.log(Level.ERROR, file.getName() + " was scanned and found to contain errors. Deletion was required in order to stop a crash from happening.");
			}
	}

	private static final ParameterizedType type = new ParameterizedType() {
		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] { ProfileEntry.class };
		}

		@Override
		public Type getRawType() {
			return List.class;
		}

		@Override
		public Type getOwnerType() {
			return null;
		}
	};

	private static class ProfileEntry {
		private final GameProfile field_152672_b;
		private final Date field_152673_c;

		private ProfileEntry(GameProfile p_i1165_2_, Date p_i1165_3_) {
			field_152672_b = p_i1165_2_;
			field_152673_c = p_i1165_3_;
		}

		public GameProfile func_152668_a() {
			return field_152672_b;
		}

		public Date func_152670_b() {
			return field_152673_c;
		}

		ProfileEntry(GameProfile p_i1166_2_, Date p_i1166_3_, Object p_i1166_4_) {
			this(p_i1166_2_, p_i1166_3_);
		}
	}

	private static class Serializer implements JsonDeserializer<Object>, JsonSerializer<Object> {

		private Serializer() {
		}

		public JsonElement func_152676_a(ProfileEntry p_152676_1_, Type p_152676_2_, JsonSerializationContext p_152676_3_) {
			JsonObject jsonobject = new JsonObject();
			jsonobject.addProperty("name", p_152676_1_.func_152668_a().getName());
			UUID uuid = p_152676_1_.func_152668_a().getId();
			jsonobject.addProperty("uuid", uuid == null ? "" : uuid.toString());
			jsonobject.addProperty("expiresOn", PlayerProfileCache.field_152659_a.format(p_152676_1_.func_152670_b()));
			return jsonobject;
		}

		public ProfileEntry func_152675_a(JsonElement p_152675_1_, Type p_152675_2_, JsonDeserializationContext p_152675_3_) {
			if (p_152675_1_.isJsonObject()) {
				JsonObject jsonobject = p_152675_1_.getAsJsonObject();
				JsonElement jsonelement1 = jsonobject.get("name");
				JsonElement jsonelement2 = jsonobject.get("uuid");
				JsonElement jsonelement3 = jsonobject.get("expiresOn");

				if (jsonelement1 != null && jsonelement2 != null) {
					String s = jsonelement2.getAsString();
					String s1 = jsonelement1.getAsString();
					Date date = null;

					if (jsonelement3 != null)
						try {
							date = PlayerProfileCache.field_152659_a.parse(jsonelement3.getAsString());
						} catch (ParseException parseexception) {
							date = null;
						}

					if (s1 != null && s != null) {
						UUID uuid;

						try {
							uuid = UUID.fromString(s);
						} catch (Throwable throwable) {
							return null;
						}

						ProfileEntry profileentry = new ProfileEntry(new GameProfile(uuid, s1), date, null);
						return profileentry;
					} else
						return null;
				} else
					return null;
			} else
				return null;
		}

		@Override
		public JsonElement serialize(Object p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
			return func_152676_a((ProfileEntry) p_serialize_1_, p_serialize_2_, p_serialize_3_);
		}

		@Override
		public Object deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
			return func_152675_a(p_deserialize_1_, p_deserialize_2_, p_deserialize_3_);
		}

		Serializer(Object p_i1163_2_) {
			this();
		}
	}
}