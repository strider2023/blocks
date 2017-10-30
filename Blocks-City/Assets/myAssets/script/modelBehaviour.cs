using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class modelBehaviour : MonoBehaviour
{
    public Vector3 targetScale;
    public float speed = 1.0F;
    private float startTime;
    private float journeyLength;
    public bool forwardLerp=false;



    private void OnEnable()
    {
        speed = .5f;
        startTime = Time.time;
        forwardLerp = false;
    }

    private void Update()
    {
        if (forwardLerp)
            doForwardLerp();
    }


    void doForwardLerp()
    {
        float distCovered = (Time.time - startTime) * speed;
        float fracJourney = distCovered / journeyLength;
        transform.localScale = Vector3.Lerp(Vector3.zero, targetScale, fracJourney);
    }

    public void makeTrueForwardLerp(Vector3 scale)
    {
        this.targetScale = scale;
        journeyLength = Vector3.Distance(Vector3.zero, targetScale);
        forwardLerp = true;
    }


}
