using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class moleculeBehaviour : MonoBehaviour
{
    public Vector3 position;
    public float speed = 1.0F;
    private float startTime;
    private float journeyLength;
    public bool forwardLerp;


    void start()
    {
        forwardLerp = false;      
    }


    private void Update()
    {
        if(forwardLerp)
        doForwardLerp();
    }


    void doForwardLerp()
    {        
        float distCovered = (Time.time - startTime) * speed;
        float fracJourney = distCovered / journeyLength;
        transform.position = Vector3.Lerp(this.transform.position, position, fracJourney);
    }

    public void makeTrueForwardLerp(Vector3 minglePosition)
    {
        this.position = minglePosition;
        journeyLength = Vector3.Distance(this.transform.position, position);
        startTime = Time.time;
        forwardLerp = true;
    }

   

}
