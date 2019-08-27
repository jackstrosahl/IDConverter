package de.themoep.idconverter;

/*
 * Minecraft ID mappings
 * Copyright (C) 2017  Max Lee (https://github.com/Phoenix616)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class EntitiesIdMappings
{
    public static final Mapping[] MAPPINGS = {
        new Mapping(4, "elder_guardian"),
        new Mapping(5, "wither_skeleton"),
        new Mapping(6, "stray"),
        new Mapping(23, "husk"),
        new Mapping(27, "zombie_villager"),
        new Mapping(28, "skeleton_horse"),
        new Mapping(29, "zombie_horse"),
        new Mapping(31, "donkey"),
        new Mapping(32, "mule"),
        new Mapping(34, "evocation_illager", "evoker"),
        new Mapping(35, "vex"),
        new Mapping(36, "vindication_illager", "vindicator"),
        new Mapping(37, "illusion_illager", "illusioner"),
        new Mapping(50, "creeper"),
        new Mapping(51, "skeleton"),
        new Mapping(52, "spider"),
        new Mapping(53, "giant"),
        new Mapping(54, "zombie"),
        new Mapping(55, "slime"),
        new Mapping(56, "ghast"),
        new Mapping(57, "zombie_pigman"),
        new Mapping(58, "enderman"),
        new Mapping(59, "cave_spider"),
        new Mapping(60, "silverfish"),
        new Mapping(61, "blaze"),
        new Mapping(62, "magma_cube"),
        new Mapping(63, "ender_dragon"),
        new Mapping(64, "wither"),
        new Mapping(65, "bat"),
        new Mapping(66, "witch"),
        new Mapping(67, "endermite"),
        new Mapping(68, "guardian"),
        new Mapping(69, "shulker"),
        new Mapping(90, "pig"),
        new Mapping(91, "sheep"),
        new Mapping(92, "cow"),
        new Mapping(93, "chicken"),
        new Mapping(94, "squid"),
        new Mapping(95, "wolf"),
        new Mapping(96, "mushroom_cow", "mooshroom"),
        new Mapping(97, "snowman", "snow_golem"),
        new Mapping(98, "ocelot"),
        new Mapping(99, "villager_golem", "iron_golem"),
        new Mapping(100, "horse"),
        new Mapping(101, "rabbit"),
        new Mapping(102, "polar_bear"),
        new Mapping(103, "llama"),
        new Mapping(105, "parrot"),
        new Mapping(120, "villager")
    };
    
    private final static Map<Integer, Mapping> BY_NUMERIC_ID = new HashMap<>();
    private final static Map<String, Mapping> BY_LEGACY_NAME = new HashMap<>();
    private final static Map<String, Mapping> BY_FLATTENING_NAME = new HashMap<>();

    static {
        for (Mapping mapping : MAPPINGS) {
            if (mapping.getNumericId() >= 0) {
                BY_NUMERIC_ID.put(mapping.getNumericId(), mapping);
            }
            if (mapping.getLegacyType() != null) {
                BY_LEGACY_NAME.put(mapping.getLegacyType(), mapping);
            }
            if (mapping.getFlatteningType() != null) {
                BY_FLATTENING_NAME.put(mapping.getFlatteningType(), mapping);
            }
        }
    }
    
    public static Mapping get(IdType type, String id) {
        switch (type) {
            case NUMERIC:
                return getById(id);
            case LEGACY:
                return getByLegacyType(id);
            case FLATTENING:
                return getByFlatteningType(id);
            default:
                throw new IllegalArgumentException(type + " is not a valid map type.");
        }
    }
    
    public static Mapping getById(String id) {
        return BY_NUMERIC_ID.get(id.toUpperCase(Locale.ENGLISH));
    }
    
    public static Mapping getByLegacyType(String oldType) {
        return BY_LEGACY_NAME.get(oldType.toUpperCase(Locale.ENGLISH));
    }
    
    public static Mapping getByFlatteningType(String flatteningType) {
        return BY_FLATTENING_NAME.get(flatteningType.toUpperCase(Locale.ENGLISH));
    }
    
    public static class Mapping {
        private final String flatteningType;
        private final String legacyType;
        private final int numericId;
        private Note note = null;
    
        public Mapping(int numericId, String legacyType, String flatteningType) {
            this.flatteningType = flatteningType != null ? flatteningType.toUpperCase(Locale.ENGLISH) : null;
            this.legacyType = legacyType != null ? legacyType.toUpperCase(Locale.ENGLISH) : null;
            this.numericId = numericId;
        }
        
        public Mapping(int numericId, String type) {
            this(numericId, type, type);
        }

        public Mapping(int numericId, String oldType, Note note) {
            this(numericId, oldType, (String) null);
            this.note = note;
        }
    
        public String getFlatteningType() {
            return flatteningType;
        }
    
        public String getLegacyType() {
            return legacyType;
        }
    
        public int getNumericId() {
            return numericId;
        }

        public String get(IdType type) {
            switch (type) {
                case NUMERIC:
                    if (getNumericId() >= 0) {
                        return String.valueOf(getNumericId());
                    }
                    return null;
                case LEGACY:
                    return getLegacyType();
                case FLATTENING:
                    return getFlatteningType();
                default:
                    throw new IllegalArgumentException(type + " is not a valid value.");
            }
        }
    
        public Note getNote() {
            return note;
        }
    }
    
    public enum IdType {
        NUMERIC("(\\W*: )(\\d+(:\\d+|))(\\W*)"),
        LEGACY("(\\W*: )(\\w+(:\\d+|))(\\W*)"),
        FLATTENING("(\\W*: )(\\w+)(\\W*)");
    
        private final String regex;
    
        IdType(String regex) {
            this.regex = regex;
        }
    
        public String getRegex() {
            return regex;
        }
    }
    
    public static class Note {
        private final String text;
    
        public Note(String text) {
            this.text = text;
        }
    
        public String getText() {
            return text;
        }
    }
}
