package com.example.savie;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AritcleItem {
    public static  final String TABLE_NAME = "item";
    public static  final String KEY_ID = "_id";

    public static final String NAME_COLUMN = "name";
    public static final String TOPICNAME_COLUMN = "topicname";
    public static final String LINK_COLUMN = "link";
    public static final String IMGSHOW_COLUMN = "imgshow";
    public static final String IMG_COLUMN = "img";
    public static final String COLOR_COLUMN = "color";
    public static final String TAG1_COLUMN = "tag1";
    public static final String TAG2_COLUMN = "tag2";
    public static final String CONTENT_COLUMN = "content";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    NAME_COLUMN + "  TEXT, "+
                    TOPICNAME_COLUMN + " TEXT, "+
                    LINK_COLUMN + " TEXT, "+
                    IMGSHOW_COLUMN + " INTEGER, "+
                    IMG_COLUMN + " INTEGER, "+
                    COLOR_COLUMN + " TEXT, "+
                    TAG1_COLUMN + " TEXT, "+
                    TAG2_COLUMN + " TEXT, "+
                    CONTENT_COLUMN + " TEXT)";

    private SQLiteDatabase db;

    public AritcleItem(Context context){
        db = DBHelper.getDatabase(context);
    }

    public void close(){
        db.close();
    }

    public Item insert(Item item){
        ContentValues cv = new ContentValues();

        cv.put(NAME_COLUMN,item.getName());
        cv.put(TOPICNAME_COLUMN,item.getTopicname());
        cv.put(LINK_COLUMN,item.getLink());
        cv.put(IMGSHOW_COLUMN,item.getImgshow());
        cv.put(IMG_COLUMN,item.getImg());
        cv.put(COLOR_COLUMN,item.getColor());
        cv.put(TAG1_COLUMN,item.getTag1());
        cv.put(TAG2_COLUMN,item.getTag2());
        cv.put(CONTENT_COLUMN,item.getContent());

        long id = db.insert(TABLE_NAME,null,cv);
        item.setId(id);
        return item;
    }

    public boolean update(Item item){
        ContentValues cv = new ContentValues();

        cv.put(NAME_COLUMN,item.getName());
        cv.put(TOPICNAME_COLUMN,item.getTopicname());
        cv.put(LINK_COLUMN,item.getLink());
        cv.put(IMGSHOW_COLUMN,item.getImgshow());
        cv.put(IMG_COLUMN,item.getImg());
        cv.put(COLOR_COLUMN,item.getColor());
        cv.put(TAG1_COLUMN,item.getTag1());
        cv.put(TAG2_COLUMN,item.getTag2());
        cv.put(CONTENT_COLUMN,item.getContent());

        String where = KEY_ID + "=" + item.getId();

        return db.update(TABLE_NAME,cv,where,null) > 0;
    }
    public boolean delete(long id){
        String where = KEY_ID + "=" + id;
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    public List<Item> getAll(){
        List<Item> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }
        cursor.close();
        return result;
    }

    public Item get(long id) {
        Item item = null;
        String where = KEY_ID + "=" + id;
        Cursor result = db.query(
                TABLE_NAME, null, where, null, null, null, null, null);
        if (result.moveToFirst()) {
            item = getRecord(result);
        }
        result.close();
        return item;
    }

    public Item getRecord(Cursor cursor){
        Item result = new Item();
        result.setId(cursor.getLong(0));
        result.setName(cursor.getString(1));
        result.setTopicname(cursor.getString(2));
        result.setLink(cursor.getString(3));
        result.setImgshow(cursor.getLong(4));
        result.setImg(cursor.getLong(5));
        result.setColor(cursor.getString(6));
        result.setTag1(cursor.getString(7));
        result.setTag2(cursor.getString(8));
        result.setContent(cursor.getString(9));
        return result;
    }

    public int getCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }
        return result;
    }
    public void clearDatabase() {
        String clearDBQuery = "DELETE FROM "+TABLE_NAME;
        db.execSQL(clearDBQuery);
    }

    public void sample(){
        Item item1 = new Item(0,"fruit","food","http://fruit.com",
                R.drawable.friut,R.drawable.fruit2,"#33B5E5","favorite","healthy","I love to eat fruit!");

        Item item2 = new Item(0,"cake","food","http://cake.com",
                R.drawable.cake,R.drawable.cake2,"#FFBB33","sweet","favorite","Cake contains lots of sugar!");

        Item item3 = new Item(0,"pancake","food","http://pancake.com",
                R.drawable.pancake,R.drawable.pancake2,"#33B5E5","favorite","unhealthy","Pancake forever!");

        Item item4 = new Item(0,"python","technology","http://python.com",
                R.drawable.python,R.drawable.python2,"#99CC00","hate","","Python!!!!!");

        insert(item1);
        insert(item2);
        insert(item3);
        insert(item4);
    }

}
