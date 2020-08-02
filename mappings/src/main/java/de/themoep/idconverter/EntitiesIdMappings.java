package de.themoep.idconverter;

/*
 * Minecraft ID IdMappings.Mappings
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
    public static final IdMappings.Mapping[] MAPPINGS = {
        new IdMappings.Mapping(4, "elder_guardian"),
        new IdMappings.Mapping(5, "wither_skeleton"),
        new IdMappings.Mapping(6, "stray"),
        new IdMappings.Mapping(23, "husk"),
        new IdMappings.Mapping(27, "zombie_villager"),
        new IdMappings.Mapping(28, "skeleton_horse"),
        new IdMappings.Mapping(29, "zombie_horse"),
        new IdMappings.Mapping(31, "donkey"),
        new IdMappings.Mapping(32, "mule"),
        new IdMappings.Mapping(34, "evocation_illager", "evoker"),
        new IdMappings.Mapping(35, "vex"),
        new IdMappings.Mapping(36, "vindication_illager", "vindicator"),
        new IdMappings.Mapping(37, "illusion_illager", "illusioner"),
        new IdMappings.Mapping(50, "creeper"),
        new IdMappings.Mapping(51, "skeleton"),
        new IdMappings.Mapping(52, "spider"),
        new IdMappings.Mapping(53, "giant"),
        new IdMappings.Mapping(54, "zombie"),
        new IdMappings.Mapping(55, "slime"),
        new IdMappings.Mapping(56, "ghast"),
        new IdMappings.Mapping(57, "zombie_pigman"),
        new IdMappings.Mapping(58, "enderman"),
        new IdMappings.Mapping(59, "cave_spider"),
        new IdMappings.Mapping(60, "silverfish"),
        new IdMappings.Mapping(61, "blaze"),
        new IdMappings.Mapping(62, "magma_cube"),
        new IdMappings.Mapping(63, "ender_dragon"),
        new IdMappings.Mapping(64, "wither"),
        new IdMappings.Mapping(65, "bat"),
        new IdMappings.Mapping(66, "witch"),
        new IdMappings.Mapping(67, "endermite"),
        new IdMappings.Mapping(68, "guardian"),
        new IdMappings.Mapping(69, "shulker"),
        new IdMappings.Mapping(90, "pig"),
        new IdMappings.Mapping(91, "sheep"),
        new IdMappings.Mapping(92, "cow"),
        new IdMappings.Mapping(93, "chicken"),
        new IdMappings.Mapping(94, "squid"),
        new IdMappings.Mapping(95, "wolf"),
        new IdMappings.Mapping(96, "mushroom_cow", "mooshroom"),
        new IdMappings.Mapping(97, "snowman", "snow_golem"),
        new IdMappings.Mapping(98, "ocelot"),
        new IdMappings.Mapping(99, "villager_golem", "iron_golem"),
        new IdMappings.Mapping(100, "horse"),
        new IdMappings.Mapping(101, "rabbit"),
        new IdMappings.Mapping(102, "polar_bear"),
        new IdMappings.Mapping(103, "llama"),
        new IdMappings.Mapping(105, "parrot"),
        new IdMappings.Mapping(120, "villager")
    };
    
    private final static Map<String, IdMappings.Mapping> BY_NUMERIC_ID = new HashMap<>();
    private final static Map<String, IdMappings.Mapping> BY_LEGACY_NAME = new HashMap<>();
    private final static Map<String, IdMappings.Mapping> BY_FLATTENING_NAME = new HashMap<>();

    static{
        Util.populateMaps(MAPPINGS, BY_NUMERIC_ID, BY_LEGACY_NAME, BY_FLATTENING_NAME);
    }
    
    public static IdMappings.Mapping get(IdMappings.IdType type, String id) {
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
    
    public static IdMappings.Mapping getById(String id) {
        return BY_NUMERIC_ID.get( id.toUpperCase(Locale.ENGLISH));
    }
    
    public static IdMappings.Mapping getByLegacyType(String oldType) {
        return BY_LEGACY_NAME.get(oldType.toUpperCase(Locale.ENGLISH));
    }
    
    public static IdMappings.Mapping getByFlatteningType(String flatteningType) {
        return BY_FLATTENING_NAME.get(flatteningType.toUpperCase(Locale.ENGLISH));
    }
}
