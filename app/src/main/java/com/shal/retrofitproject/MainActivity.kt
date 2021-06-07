package com.shal.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.shal.retrofitproject.models.Idea
import com.shal.retrofitproject.services.IIdeaServices
import com.shal.retrofitproject.services.ServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            val iIdeaServices = ServiceBuilder.buildService(IIdeaServices::class.java)

            /*val ideas = iIdeaServices.getIdea(2)
            ideas.enqueue(object : retrofit2.Callback<Idea> {
                override fun onResponse(call: Call<Idea>?, response: Response<Idea>?) {
                    Log.i("TAG", "Print the message from server ${response?.body()}")
                    val ideas = response?.body() as Idea
                    Log.i("TAG", "Print the message from server ${ideas.name}")
                }

                override fun onFailure(call: Call<Idea>?, t: Throwable?) {
                    Log.i("TAG", "Print the message from server ${t?.message}")
                }

            })*/
         CoroutineScope(Dispatchers.IO).launch {
                val idea = Idea( null,"without header", "New idea added to list", "POC", "Pratibha")
                val postIdea = iIdeaServices.postIdea(idea)
             //val idea = postIdea.execute().body();
             postIdea.enqueue(object : retrofit2.Callback<Idea> {
                    override fun onResponse(call: Call<Idea>?, response: Response<Idea>?) {
                            Log.i("TAG", "Print the message from server ${response?.body()}")
                    }

                    override fun onFailure(call: Call<Idea>?, t: Throwable?) {
                        Log.i("TAG", "Print the error message ${t?.message}")
                    }

                })
            }


         /*  CoroutineScope(Dispatchers.IO).launch {
                //val idea = Idea(1, "New Idea", "New idea added to list", "POC", "Pratibha")
                val postIdea = iIdeaServices.put(1, "Urvang idea", "New idea added to list", "POC", "Pratibha")
                postIdea.enqueue(object : retrofit2.Callback<Idea> {
                    override fun onResponse(call: Call<Idea>?, response: Response<Idea>?) {
                        Log.i("TAG", "Print the message from server ${response?.body()}")
                    }

                    override fun onFailure(call: Call<Idea>?, t: Throwable?) {
                        Log.i("TAG", "Print the error message ${t?.message}")
                    }

                })
            }*/

          // val iIdeaServices = ServiceBuilder.buildService(IIdeaServices::class.java)



  /*          val iIdeaServices = ServiceBuilder.buildService(IMessageServices::class.java)
            val ideas = iIdeaServices.getMessages("http://10.0.2.2:7000/messages")
            ideas.enqueue(object : retrofit2.Callback<String> {
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    Log.i("TAG", "Print the message from server ${response?.body()}")
                    val ideas = response?.body()
                    Log.i("TAG", "Print the message from server ${ideas}")
                }

                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    Log.i("TAG", "Print the message from server ${t?.message}")
                }

            })*/


         /*   val hashMap = HashMap<String, String>()
            hashMap["count"] = "1"
            hashMap["owner"] = "Jim"
            val ideasByOwner = iIdeaServices.getIdeasByOwner(hashMap)
            ideasByOwner.enqueue(object : retrofit2.Callback<List<Idea>>{
                override fun onResponse(call: Call<List<Idea>>?, response: Response<List<Idea>>?) {
                    Log.i("TAG", "Print the ideas ${response?.body()}")
                    val ideas = response?.body() as List<Idea>
                    Log.i("TAG", "Print the ideas ${ideas.size}")
                }

                override fun onFailure(call: Call<List<Idea>>, t: Throwable?) {
                    Log.i("TAG", "Print the ideas ${t?.message}")
                }

            })*/
        }


        /*      message.enqueue(object : retrofit2.Callback<List<Idea>> {
                  override fun onResponse(call: Call<List<Idea>>?, response: Response<String>?) {

                      Log.i("TAG", "Print the message from server ${response?.body()}")
                  }

                  override fun onFailure(call: Call<List<Idea>>?, t: Throwable?) {
                      Log.i("TAG", "Print the message from server ${t?.message}")
                  }

              })*/
    }


}