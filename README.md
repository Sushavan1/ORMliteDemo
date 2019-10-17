# ORMliteDemo
ORMlite DataBase Intrigration
ORM Light 

Step 1. Create a Database Access Object(Dao). It's same as model class

	Class Name = Table Name
	Varibale= DatabaseField

Step 2. Create a DataBaseHelper inherit OrmLiteSqliteOpenHelper 
	
	Create,update Database/table
	
	Initilige DAO 

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DataBaseHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "UserDao.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<UserDao,Integer> usersDao;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(TAG,"Table Created");
            TableUtils.createTable(connectionSource, UserDao.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, UserDao.class,true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<UserDao,Integer> getUsersDao(){
        if(usersDao==null) {
            try {
                usersDao=getDao(UserDao.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usersDao;
    }
}

Step 3. Create a Database Interface inculed some functions(insert, update,delete,fetchdata ) which are access a DB. 

Step 4. Create a DatabaseManager
	
	It's a Singleton,that return instance of DataBaseHelper.

Step 5. Create a Repository class which implements this Database Interface
	
	Implement all action to access Database by DataBaseHelper.

Step 6. 
	 DatabaseManager.init(MainActivity.this);
	 UserRepository userRepo=new UserRepository();
	
	To access Datbase You have to use Repository's instance (Ex: UserRepository)






