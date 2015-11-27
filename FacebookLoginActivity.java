public class FacebookLoginActivity extends Activity {
  private Button mLoginButton;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_facebook_login);

      mLoginButton = findViewById(R.id.login_button);
      mLoginButton.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {

          ParseFacebookUtils.logIn(this, new LogInCallback() {

            @Override
            public void done(ParseUser user, ParseException err) {
            if (user == null) {
            Log.d(TAG, "Uh oh. The user cancelled the Facebook login.");
            } else if (user.isNew()) {
            Log.d(TAG, "User signed up and logged in through Facebook!");
            } else {
            Log.d(TAG, "User logged in through Facebook!");
            }
            }
            });
          }
          });
    }

  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
    }

}
