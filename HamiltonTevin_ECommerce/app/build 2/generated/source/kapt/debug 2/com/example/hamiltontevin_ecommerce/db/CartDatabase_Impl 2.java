package com.example.hamiltontevin_ecommerce.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CartDatabase_Impl extends CartDatabase {
  private volatile CartDAO _cartDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Cart_data_table` (`item_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item_title` TEXT NOT NULL, `item_price` REAL NOT NULL, `item_description` TEXT NOT NULL, `item_category` TEXT NOT NULL, `item_image` TEXT NOT NULL, `item_rating` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ff966f950e917992013992bf2b28a5f9')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Cart_data_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCartDataTable = new HashMap<String, TableInfo.Column>(7);
        _columnsCartDataTable.put("item_id", new TableInfo.Column("item_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartDataTable.put("item_title", new TableInfo.Column("item_title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartDataTable.put("item_price", new TableInfo.Column("item_price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartDataTable.put("item_description", new TableInfo.Column("item_description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartDataTable.put("item_category", new TableInfo.Column("item_category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartDataTable.put("item_image", new TableInfo.Column("item_image", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartDataTable.put("item_rating", new TableInfo.Column("item_rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCartDataTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCartDataTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCartDataTable = new TableInfo("Cart_data_table", _columnsCartDataTable, _foreignKeysCartDataTable, _indicesCartDataTable);
        final TableInfo _existingCartDataTable = TableInfo.read(_db, "Cart_data_table");
        if (! _infoCartDataTable.equals(_existingCartDataTable)) {
          return new RoomOpenHelper.ValidationResult(false, "Cart_data_table(com.example.hamiltontevin_ecommerce.db.Cart).\n"
                  + " Expected:\n" + _infoCartDataTable + "\n"
                  + " Found:\n" + _existingCartDataTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ff966f950e917992013992bf2b28a5f9", "1485e8726ade77a089c9a11d9a32d1d4");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Cart_data_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Cart_data_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CartDAO.class, CartDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public CartDAO getCartDAO() {
    if (_cartDAO != null) {
      return _cartDAO;
    } else {
      synchronized(this) {
        if(_cartDAO == null) {
          _cartDAO = new CartDAO_Impl(this);
        }
        return _cartDAO;
      }
    }
  }
}
