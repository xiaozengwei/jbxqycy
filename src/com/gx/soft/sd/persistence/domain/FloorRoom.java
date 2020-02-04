package com.gx.soft.sd.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "floor_room", schema = "jbxqycy", catalog = "")
public class FloorRoom {
    private String rowId;
    private String rowName;
    private String pFloorId;
    private String pFloorName;
    private String floorType;

    @Id
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "row_name")
    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    @Basic
    @Column(name = "p_floor_id")
    public String getpFloorId() {
        return pFloorId;
    }

    public void setpFloorId(String pFloorId) {
        this.pFloorId = pFloorId;
    }

    @Basic
    @Column(name = "p_floor_name")
    public String getpFloorName() {
        return pFloorName;
    }

    public void setpFloorName(String pFloorName) {
        this.pFloorName = pFloorName;
    }

    @Basic
    @Column(name = "floor_type")
    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FloorRoom floorRoom = (FloorRoom) o;

        if (rowId != null ? !rowId.equals(floorRoom.rowId) : floorRoom.rowId != null) return false;
        if (rowName != null ? !rowName.equals(floorRoom.rowName) : floorRoom.rowName != null) return false;
        if (pFloorId != null ? !pFloorId.equals(floorRoom.pFloorId) : floorRoom.pFloorId != null) return false;
        if (pFloorName != null ? !pFloorName.equals(floorRoom.pFloorName) : floorRoom.pFloorName != null) return false;
        if (floorType != null ? !floorType.equals(floorRoom.floorType) : floorRoom.floorType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (rowName != null ? rowName.hashCode() : 0);
        result = 31 * result + (pFloorId != null ? pFloorId.hashCode() : 0);
        result = 31 * result + (pFloorName != null ? pFloorName.hashCode() : 0);
        result = 31 * result + (floorType != null ? floorType.hashCode() : 0);
        return result;
    }
}
