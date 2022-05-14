package jose.flores.acft

data class Event(
    val title: String,
    val subtitle: String,
    val description: String,
    val properTechnique: String,
    val safetyTips: String?,
    val fitnessComponents: String,
    val standardEquipment: String,
    val lastScore: Int?,
    val highestScore:Int?,
    val eventImage:Int,//TODO: ADD EVENT IMAGE FROM ACFT OFFICIAL WEBSITE
    val videoId: String,
    val howToTrainVideoIds:List<String> ,//TODO: here we can reference workout plans or specific exercises to train/prepare for event
)
